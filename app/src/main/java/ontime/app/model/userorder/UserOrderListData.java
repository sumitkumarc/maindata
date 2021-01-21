package ontime.app.model.userorder;

import ontime.app.model.usermain.OrderCancelled;
import ontime.app.model.usermain.OrderFinished;
import ontime.app.model.usermain.OrderProccessing;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserOrderListData {

    @SerializedName("proccessing")
    @Expose
    private List<OrderProccessing> proccessing = null;
    @SerializedName("finished")
    @Expose
    private List<OrderFinished> finished = null;
    @SerializedName("cancelled")
    @Expose
    private List<OrderCancelled> ocancelled = null;

    public List<OrderCancelled> getOCancelled() {
        return ocancelled;
    }

    public void setOCancelled(List<OrderCancelled> ocancelled) {
        this.ocancelled = ocancelled;
    }

    public List<OrderFinished> getFinished() {
        return finished;
    }

    public void setFinished(List<OrderFinished> finished) {
        this.finished = finished;
    }
    public List<OrderProccessing> getProccessing() {
        return proccessing;
    }

    public void setProccessing(List<OrderProccessing> proccessing) {
        this.proccessing = proccessing;
    }

}
