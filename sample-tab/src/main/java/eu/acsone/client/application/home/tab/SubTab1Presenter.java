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

import eu.acsone.client.place.NameTokens;

public class SubTab1Presenter extends
		Presenter<SubTab1Presenter.MyView, SubTab1Presenter.MyProxy> {

	private final DispatchAsync dispatchAsync;

	@NameToken(NameTokens.nested1)
	@ProxyStandard
	@TabInfo(container = HomeTab2Presenter.class, priority = 0, label = "sub tab1")
	public interface MyProxy extends TabContentProxyPlace<SubTab1Presenter> {
	}

	public interface MyView extends View {
	}

	@Inject
	public SubTab1Presenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, final DispatchAsync dispatchAsync) {
		super(eventBus, view, proxy, HomeTab2Presenter.TYPE_SetTabContent);
		this.dispatchAsync = dispatchAsync;
	}
}
