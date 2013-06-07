package eu.acsone.client.application.home.tab;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.RequestTabsHandler;
import com.gwtplatform.mvp.client.TabContainerPresenter;
import com.gwtplatform.mvp.client.TabView;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.RequestTabs;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.NonLeafTabContentProxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

import eu.acsone.client.application.home.HomePagePresenter;
import eu.acsone.client.gxt.tabs.GXTTabContainerPresenter;
import eu.acsone.client.gxt.tabs.GXTTabPanel;
import eu.acsone.client.place.NameTokens;

public class HomeTab2Presenter
		extends
		GXTTabContainerPresenter<HomeTab2Presenter.MyView, HomeTab2Presenter.MyProxy> {

	private final DispatchAsync dispatchAsync;

	@ProxyCodeSplit
	@TabInfo(container = HomePagePresenter.class, label = "Nested", priority = 1, nameToken = NameTokens.nested1)
	public interface MyProxy extends NonLeafTabContentProxy<HomeTab2Presenter> {
	}

	public interface MyView extends TabView, GXTTabPanel {
	}

	/**
	 * This will be the event sent to our "unknown" child presenters, in order
	 * for them to register their tabs.
	 */
	@RequestTabs
	public static final Type<RequestTabsHandler> TYPE_RequestTabs = new Type<RequestTabsHandler>();

	/**
	 * Use this in leaf presenters, inside their {@link #revealInParent} method.
	 */
	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_SetTabContent = new Type<RevealContentHandler<?>>();

	@Inject
	public HomeTab2Presenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, final DispatchAsync dispatchAsync) {
		super(eventBus, view, proxy, TYPE_SetTabContent, TYPE_RequestTabs,
				HomePagePresenter.TYPE_SetTabContent);
		this.dispatchAsync = dispatchAsync;
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	@Override
	protected void onReset() {
		super.onReset();
	}
}
