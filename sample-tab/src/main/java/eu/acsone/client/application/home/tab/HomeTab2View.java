package eu.acsone.client.application.home.tab;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class HomeTab2View extends ViewImpl implements HomeTab2Presenter.MyView {

 HTMLPanel content;
    
  @Inject
  public HomeTab2View() {
    content = new HTMLPanel("tab2 lorem ipsum");
  }
  
    @Override
  public Widget asWidget() {
    return content;
  }

}
