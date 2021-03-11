
package tk.pankajb.Responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppMetadata {

    @SerializedName("provider")
    @Expose
    private String provider;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

}
