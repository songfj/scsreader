/*
 * SCS Reader
 * Copyright (C) 2010  Martin W. Kirst
 *                     (master_jaf at users dot sourceforge dot net)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.scs.reader.microcommands;

import java.io.IOException;

import net.scs.reader.IScsDataProvider;
import net.scs.reader.IVirtualPrinter;

/**
 * Control Code: PP
 * EBCDIC      : X'34xxnn'
 * Name        : Presentation position (see Table 17)
 * Line Support: Yes
 * PCL Support : Yes
 * @see <a href="http://publib.boulder.ibm.com/infocenter/zos/v1r10/index.jsp?topic=/com.ibm.zos.r10.aopu000/appscs.htm">z/OS V1R8.0-V1R10.0 Infoprint Server User's Guide S544-5746-09</a>
 */
public class PresentationPosition extends PrinterMicroCommandAdapter {

	public final static byte OPCODE = 0x34;

	private final byte functionCode;
	private final byte functionValue;

	public PresentationPosition(IScsDataProvider provider) throws IOException {
		super(provider);
		final byte[] data = provider.getBytes(3);
		if (data == null || data.length != 3) {
			throw new IOException("Not enough input data. 2 bytes expected!");
		}
		this.functionCode = data[1];
		this.functionValue = data[2];
	}

	@Override
	public void print(IVirtualPrinter printer) {
		int position = printer.getHeadDirH();
		switch (functionCode) {
		case (byte)0xC0:
			printer.setHeadDirH(functionValue & 0xFF);
			break;
		case (byte)0xC4:
			printer.setHeadDirV(functionValue & 0xFF);
			break;
		case (byte)0xC8:
			printer.setHeadDirH( position + (functionValue & 0xFF) );
			break;
		case (byte)0x4C:
			printer.setHeadDirV( position + (functionValue & 0xFF) );
			break;
		default:
			throw new UnsupportedOperationException("Presentation Position: not supported function code: " + Integer.toHexString(functionCode&0xFF) + " | position: " + offset);
		}
	}

	/* (non-Javadoc)
	 * @see com.ibm.scs.microcommands.PrinterMicroCommandAdapter#getLength()
	 */
	@Override
	public int getLength() {
		return 3;
	}



}
