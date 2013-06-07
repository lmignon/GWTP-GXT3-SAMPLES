package eu.acsone.client.application.home;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.ChangeTabHandler;
import com.gwtplatform.mvp.client.RequestTabsHandler;
import com.gwtplatform.mvp.client.TabView;
import com.gwtplatform.mvp.client.annotations.ChangeTab;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.RequestTabs;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

import eu.acsone.client.application.ApplicationPresenter;
import eu.acsone.client.gxt.tabs.GXTTabContainerPresenter;
import eu.acsone.client.gxt.tabs.GXTTabPanel;

public class HomePagePresenter extends GXTTabContainerPresenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
    public interface MyView extends TabView, GXTTabPanel {
    }

    @ProxyStandard
    public interface MyProxy extends Proxy<HomePagePresenter> {
    }

    @RequestTabs
    public static final Type<RequestTabsHandler> TYPE_RequestTabs = new Type<RequestTabsHandler>();

    /**
     * Fired by child proxie's when their tab content is changed.
     */
    @ChangeTab
    public static final Type<ChangeTabHandler> TYPE_ChangeTab = new Type<ChangeTabHandler>();
    
    /**
     * Use this in leaf presenters, inside their {@link #revealInParent} method.
     */
    @ContentSlot
    public static final Type<RevealContentHandler<?>> TYPE_SetTabContent = new Type<RevealContentHandler<?>>();
    
    
    @Inject
    public HomePagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
    	super(eventBus, view, proxy, TYPE_SetTabContent, TYPE_RequestTabs, TYPE_ChangeTab, RevealType.Root);
    }
    
    @Override
    protected void revealInParent() {
      RevealContentEvent.fire(this, ApplicationPresenter.SLOT_content, this);
    }
}
