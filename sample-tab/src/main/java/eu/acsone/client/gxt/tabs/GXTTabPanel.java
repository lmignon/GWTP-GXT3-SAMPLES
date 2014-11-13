/**
 *    Authors: Laurent Mignon
 *    Copyright (c) 2012 Acsone SA/NV (http://www.acsone.eu)
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Affero General Public License as
 *    published by the Free Software Foundation, either version 3 of the
 *    License, or (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Affero General Public License for more details.
 *
 *    You should have received a copy of the GNU Affero General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.acsone.client.gxt.tabs;

import com.gwtplatform.mvp.client.Tab;

public interface GXTTabPanel {
	 /**
     *  Sets the next active tab. 
     *  The method is called before the set contentSlot and setActiveTab
     *  to give a chance to the view to register the next active tab on which 
     *  the seContent must be applied
     *
     * @param tab The tab to activate.
     */
    void setNextActiveTab(Tab tab);
    
    
    /**
     * Renders all the tabs in the view
     * The method is called after all tabs have been added to be sure
     * that tabs are rendered in the expected priority
     */
    void renderTabs();
}
