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

import net.scs.reader.EndOfFileSignal;
import net.scs.reader.IScsDataProvider;
import net.scs.reader.UnsupportedControlCodeException;

public class NotSupportedControlCode extends PrinterMicroCommandAdapter {

	public NotSupportedControlCode(IScsDataProvider dataProvider) throws EndOfFileSignal, IOException {
		super(dataProvider);
		throw new UnsupportedControlCodeException(this.offset, dataProvider.getByte());
	}

}
