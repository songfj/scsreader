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
package net.scs.reader;

import java.io.IOException;

/**
 * Signals EOF ;-)
 */
public class EndOfFileSignal extends IOException {

	private static final long serialVersionUID = -3207526442938112229L;

	public EndOfFileSignal() {
		super();
	}

	public EndOfFileSignal(String message, Throwable cause) {
		super(message, cause);
	}

	public EndOfFileSignal(String message) {
		super(message);
	}

	public EndOfFileSignal(Throwable cause) {
		super(cause);
	}

}
