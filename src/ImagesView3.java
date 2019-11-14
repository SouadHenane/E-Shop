import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ImagesView3 implements Serializable {

    private List<String> images3;

    public List<String> getImages3() {
        return images3;
    }

    public void setImages3(List<String> images3) {
        this.images3 = images3;
    }

    @PostConstruct
    public void init() {
        images3 = new ArrayList<String>();

        for (int i = 1; i <= 11; i++) {
            images3.add("women" + i + ".jpg");
        }
    }


}



