package eu.acsone.client.application.home.tab;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.NonLeafTabContentProxy;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;

import eu.acsone.client.application.home.HomePagePresenter;

public class HomeTab2Presenter extends Presenter<HomeTab2Presenter.MyView, HomeTab2Presenter.MyProxy> {

	private final DispatchAsync dispatchAsync;

	@ProxyStandard
	@NameToken("t2")
	@TabInfo(container = HomePagePresenter.class, priority = 1, label = "tab2")
	public interface MyProxy extends
			TabContentProxyPlace<HomeTab2Presenter> {
	}

	public interface MyView extends View {
	}

	@Inject
	public HomeTab2Presenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, final DispatchAsync dispatchAsync) {
		super(eventBus, view, proxy, HomePagePresenter.TYPE_SetTabContent);
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
