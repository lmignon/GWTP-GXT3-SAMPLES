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
}
