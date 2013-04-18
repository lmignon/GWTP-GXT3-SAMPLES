package eu.acsone.client.application.home.tab;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class HomeTab1View extends ViewImpl implements HomeTab1Presenter.MyView {

 HTMLPanel content;
    
  @Inject
  public HomeTab1View() {
    content = new HTMLPanel("lorem ipsum");
  }
  
    @Override
  public Widget asWidget() {
    return content;
  }

}
