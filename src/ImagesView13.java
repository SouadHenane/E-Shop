import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ImagesView13 implements Serializable {

    private List<String> images;


    public void setImages(List<String> images) {
        this.images = images;
    }

    @PostConstruct
    public void init() {

        images = new ArrayList<String>();
        for (int i = 1; i <= 14; i++) {
            images.add("cl" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }
}



