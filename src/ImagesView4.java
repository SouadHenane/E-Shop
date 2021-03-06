import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ImagesView4 implements Serializable {

    private List<String> images;


    public void setImages(List<String> images) {
        this.images = images;
    }

    @PostConstruct

    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 13; i++) {
            images.add("watch" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }
}



