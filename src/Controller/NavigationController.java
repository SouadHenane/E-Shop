package Controller;


import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class NavigationController implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManagedProperty(value = "#{param.pageId}")
    private String pageId;

    public String moveToProductPage() {
        return "Product";
    }


    public String moveToLoginPage() {
        return "login";
    }
    public String moveToContactPage() {
        return "contact";
    }

    public String moveToHomePage() {
        return "MyShop";
    }

    public String processHomePage() {
        return "page";
    }

    public String processProductPage() {
        return "page";
    }

    public String processLoginPage() {
        return "page";
    }

    public String processContactPage() {
        return "page";
    }

    public String showPage() {
        if(pageId == null) {
            return "MyShop";
        }

        if(pageId.equals("1")) {
            return "Product";
        }
        else if(pageId.equals("2")) {
            return "login";
        }
        else if(pageId.equals("3")) {
            return "contact";
        }else {
            return "MyShop";
        }
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
}