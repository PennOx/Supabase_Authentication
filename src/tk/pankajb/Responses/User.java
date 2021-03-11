
package tk.pankajb.Responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import tk.pankajb.Responses.SignInResponse.UserMetadata;

public class User {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("aud")
    @Expose
    private String aud;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("confirmed_at")
    @Expose
    private String confirmedAt;
    @SerializedName("confirmation_sent_at")
    @Expose
    private String confirmationSentAt;
    @SerializedName("last_sign_in_at")
    @Expose
    private String lastSignInAt;
    @SerializedName("app_metadata")
    @Expose
    private AppMetadata appMetadata;
    @SerializedName("user_metadata")
    @Expose
    private UserMetadata userMetadata;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(String confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public String getConfirmationSentAt() {
        return confirmationSentAt;
    }

    public void setConfirmationSentAt(String confirmationSentAt) {
        this.confirmationSentAt = confirmationSentAt;
    }

    public String getLastSignInAt() {
        return lastSignInAt;
    }

    public void setLastSignInAt(String lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }

    public AppMetadata getAppMetadata() {
        return appMetadata;
    }

    public void setAppMetadata(AppMetadata appMetadata) {
        this.appMetadata = appMetadata;
    }

    public UserMetadata getUserMetadata() {
        return userMetadata;
    }

    public void setUserMetadata(UserMetadata userMetadata) {
        this.userMetadata = userMetadata;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
