package eu.acsone.client.application.home.tab;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;

import eu.acsone.client.application.home.HomePagePresenter;
import eu.acsone.client.place.NameTokens;

public class HomeTab1Presenter extends
		Presenter<HomeTab1Presenter.MyView, HomeTab1Presenter.MyProxy> {

	private final DispatchAsync dispatchAsync;

	@NameToken(NameTokens.home)
	@ProxyStandard
	@TabInfo(container = HomePagePresenter.class, priority = 1, label = "tab1")
	public interface MyProxy extends TabContentProxyPlace<HomeTab1Presenter> {
	}

	public interface MyView extends View {
	}

	@Inject
	public HomeTab1Presenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, final DispatchAsync dispatchAsync) {
		super(eventBus, view, proxy, HomePagePresenter.TYPE_SetTabContent);
		this.dispatchAsync = dispatchAsync;
	}
}
