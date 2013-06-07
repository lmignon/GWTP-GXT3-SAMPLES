package eu.acsone.client.application.home.tab;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class SubTab1View extends ViewImpl implements SubTab1Presenter.MyView {

 HTMLPanel content;
    
  @Inject
  public SubTab1View() {
    content = new HTMLPanel("nested lorem ipsum");
  }
  
    @Override
  public Widget asWidget() {
    return content;
  }

}
