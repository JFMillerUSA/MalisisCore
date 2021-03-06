/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Ordinastie
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.malisis.core.packet;

import net.malisis.core.MalisisCore;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * Global handler for {@link MalisisCore} messages.
 *
 * @author Ordinastie
 *
 */
public class NetworkHandler
{
	public static int OPENINVENTORY = 1;
	public static int UPDATEINVENTORYSLOTS = 2;
	public static int INVENTORYACTION = 3;
	public static SimpleNetworkWrapper network;

	/**
	 * Initializes the handle. Creates the network wrapper and registers the different handlers.
	 *
	 * @param channelName the channel name
	 */
	public static void init(String channelName)
	{
		network = new SimpleNetworkWrapper(channelName);

		network.registerMessage(OpenInventoryMessage.class, OpenInventoryMessage.Packet.class, OPENINVENTORY, Side.CLIENT);
		network.registerMessage(UpdateInventorySlotsMessage.class, UpdateInventorySlotsMessage.Packet.class, UPDATEINVENTORYSLOTS,
				Side.CLIENT);
		network.registerMessage(InventoryActionMessage.class, InventoryActionMessage.Packet.class, INVENTORYACTION, Side.SERVER);
	}
}
