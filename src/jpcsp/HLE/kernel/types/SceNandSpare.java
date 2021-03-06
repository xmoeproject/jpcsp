/*
This file is part of jpcsp.

Jpcsp is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Jpcsp is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jpcsp.  If not, see <http://www.gnu.org/licenses/>.
 */
package jpcsp.HLE.kernel.types;

public class SceNandSpare extends pspAbstractMemoryMappedStructure {
	public int userEcc[] = new int[3];
	public int reserved1;
	public int blockFmt;
	public int blockStat;
	public int lbn;
	public int id;
	public int spareEcc[] = new int[2];
	public int reserved2[] = new int[2];

	@Override
	protected void read() {
		userEcc[0] = read8(); // Offset 0
		userEcc[1] = read8(); // Offset 1
		userEcc[2] = read8(); // Offset 2
		reserved1 = read8(); // Offset 3
		blockFmt = read8(); // Offset 4
		blockStat = read8(); // Offset 5
		lbn = endianSwap16((short) read16()); // Offset 6
		id = read32(); // Offset 8
		spareEcc[0] = read8(); // Offset 12
		spareEcc[1] = read8(); // Offset 13
		reserved2[0] = read8(); // Offset 14
		reserved2[1] = read8(); // Offset 15
	}

	@Override
	protected void write() {
		write8((byte) userEcc[0]);
		write8((byte) userEcc[1]);
		write8((byte) userEcc[2]);
		write8((byte) reserved1);
		write8((byte) blockFmt);
		write8((byte) blockStat);
		write16((short) endianSwap16((short) lbn));
		write32(id);
		write8((byte) spareEcc[0]);
		write8((byte) spareEcc[1]);
		write8((byte) reserved2[0]);
		write8((byte) reserved2[1]);
	}

	@Override
	public int sizeof() {
		return 16;
	}
}
