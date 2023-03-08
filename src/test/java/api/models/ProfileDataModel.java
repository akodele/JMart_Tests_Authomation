package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileDataModel {
    UserModel user;
    ProfileModel[] profiles;

    public ProfileModel[] getProfiles() {
        return profiles;
    }

    public UserModel getUser() {
        return user;
    }
}
