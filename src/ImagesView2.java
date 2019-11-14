import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ImagesView2 implements Serializable {

    private List<String> images2;


    public List<String> getImages2() {
        return images2;
    }

    public void setImages2(List<String> images2) {
        this.images2 = images2;
    }

    @PostConstruct
    public void init() {
        images2 = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {
            images2.add("acc" + i + ".jpg");
        }
    }


}



