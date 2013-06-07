package eu.acsone.client.gxt.tabs;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.ChangeTabHandler;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.RequestTabsHandler;
import com.gwtplatform.mvp.client.TabContainerPresenter;
import com.gwtplatform.mvp.client.TabPanel;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.TabContentProxy;

/**
 * A {@link TabContainerPresenter} specialized for GXT. It defer from the original {@link TabContainerPresenter}
 *  since the ChangeTab method is called before calling the super.setInSlot giving a chance to
 *  our {@link SimpleTabPanel} to keep a reference to the activeTab before setting the content
 * @author lmi
 *
 * @param <V>
 * @param <Proxy_>
 */
public abstract class GXTTabContainerPresenter<V extends View & TabPanel & GXTTabPanel, Proxy_ extends Proxy<?>> extends TabContainerPresenter<V, Proxy_> {
	
	private final Object tabContentSlot;
	
	public GXTTabContainerPresenter(EventBus eventBus, V view, Proxy_ proxy,
			Object tabContentSlot, Type<RequestTabsHandler> requestTabsEventType) {
		super(eventBus, view, proxy, tabContentSlot, requestTabsEventType);
		this.tabContentSlot = tabContentSlot;
	}

	public GXTTabContainerPresenter(EventBus eventBus, V view, Proxy_ proxy,
			Object tabContentSlot,
			Type<RequestTabsHandler> requestTabsEventType,
			com.gwtplatform.mvp.client.Presenter.RevealType revealType) {
		super(eventBus, view, proxy, tabContentSlot, requestTabsEventType, revealType);
		this.tabContentSlot = tabContentSlot;
	}

	public GXTTabContainerPresenter(EventBus eventBus, V view, Proxy_ proxy,
			Object tabContentSlot,
			Type<RequestTabsHandler> requestTabsEventType,
			Type<ChangeTabHandler> changeTabType,
			com.gwtplatform.mvp.client.Presenter.RevealType revealType,
			Type<RevealContentHandler<?>> slot) {
		super(eventBus, view, proxy, tabContentSlot, requestTabsEventType,
				changeTabType, revealType, slot);
		this.tabContentSlot = tabContentSlot;
	}

	public GXTTabContainerPresenter(EventBus eventBus, V view, Proxy_ proxy,
			Object tabContentSlot,
			Type<RequestTabsHandler> requestTabsEventType,
			Type<ChangeTabHandler> changeTabType,
			com.gwtplatform.mvp.client.Presenter.RevealType revealType) {
		super(eventBus, view, proxy, tabContentSlot, requestTabsEventType,
				changeTabType, revealType);
		this.tabContentSlot = tabContentSlot;
	}

	public GXTTabContainerPresenter(EventBus eventBus, V view, Proxy_ proxy,
			Object tabContentSlot,
			Type<RequestTabsHandler> requestTabsEventType,
			Type<ChangeTabHandler> changeTabType,
			Type<RevealContentHandler<?>> slot) {
		super(eventBus, view, proxy, tabContentSlot, requestTabsEventType,
				changeTabType, slot);
		this.tabContentSlot = tabContentSlot;
	}

	public GXTTabContainerPresenter(EventBus eventBus, V view, Proxy_ proxy,
			Object tabContentSlot,
			Type<RequestTabsHandler> requestTabsEventType,
			Type<RevealContentHandler<?>> slot) {
		super(eventBus, view, proxy, tabContentSlot, requestTabsEventType, slot);
		this.tabContentSlot = tabContentSlot;
	}
	
	@Override
	public void setInSlot(Object slot, PresenterWidget<?> content) {
		if (slot == tabContentSlot) {
            try {
                Presenter<?, ?> presenter = (Presenter<?, ?>) content;
                TabContentProxy<?> proxy = (TabContentProxy<?>) presenter.getProxy();
                getView().setNextActiveTab(proxy.getTab());
            } catch (Exception e) {
                // We can't cast, no worry, we just won't highlight a tab
            }
        }
        super.setInSlot(slot, content);
	}

}
