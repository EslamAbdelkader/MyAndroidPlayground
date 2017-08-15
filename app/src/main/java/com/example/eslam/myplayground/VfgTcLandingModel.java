package com.example.eslam.myplayground;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Eslam on 8/14/2017.
 */

public class VfgTcLandingModel implements Parcelable {
    public static final Creator<VfgTcLandingModel> CREATOR = new Creator<VfgTcLandingModel>() {
        @Override
        public VfgTcLandingModel createFromParcel(Parcel in) {
            return new VfgTcLandingModel(in);
        }

        @Override
        public VfgTcLandingModel[] newArray(int size) {
            return new VfgTcLandingModel[size];
        }
    };
    String title;
    String header;
    String description;
    String buttonText;
    List<PermissionItem> permissionItems;
    String footer;
    String privacyText;
    String termsText;

    public VfgTcLandingModel() {
    }

    public VfgTcLandingModel(String title, String header, String description, String buttonText, List<PermissionItem> permissionItems, String footer, String privacyText, String termsText) {
        this.title = title;
        this.header = header;
        this.description = description;
        this.buttonText = buttonText;
        this.permissionItems = permissionItems;
        this.footer = footer;
        this.privacyText = privacyText;
        this.termsText = termsText;
    }

    protected VfgTcLandingModel(Parcel in) {
        title = in.readString();
        header = in.readString();
        description = in.readString();
        buttonText = in.readString();
        footer = in.readString();
        privacyText = in.readString();
        termsText = in.readString();
        permissionItems = in.createTypedArrayList(PermissionItem.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(header);
        dest.writeString(description);
        dest.writeString(buttonText);
        dest.writeString(footer);
        dest.writeString(privacyText);
        dest.writeString(termsText);
        dest.writeTypedList(permissionItems);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getTermsText() {

        return termsText;
    }

    public void setTermsText(String termsText) {
        this.termsText = termsText;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getPrivacyText() {
        return privacyText;
    }

    public void setPrivacyText(String privacyText) {
        this.privacyText = privacyText;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public List<PermissionItem> getPermissionItems() {
        return permissionItems;
    }

    public void setPermissionItems(List<PermissionItem> permissionItems) {
        this.permissionItems = permissionItems;
    }

    public static class PermissionItem implements Parcelable {
        public static final Creator<PermissionItem> CREATOR = new Creator<PermissionItem>() {
            @Override
            public PermissionItem createFromParcel(Parcel in) {
                return new PermissionItem(in);
            }

            @Override
            public PermissionItem[] newArray(int size) {
                return new PermissionItem[size];
            }
        };
        String title;
        String description;
        PermissionIconEnum permissionIcon;
        Bitmap icon;

        public PermissionItem() {
        }

        public PermissionItem(String title, String description, Bitmap icon) {
            this.title = title;
            this.description = description;
            this.icon = icon;
        }

        public PermissionItem(String title, String description, PermissionIconEnum permissionIcon) {
            this.title = title;
            this.description = description;
            this.permissionIcon = permissionIcon;
        }

        protected PermissionItem(Parcel in) {
            title = in.readString();
            description = in.readString();
            String permissionIconValue = in.readString();
            if (permissionIconValue != null)
                permissionIcon = PermissionIconEnum.valueOf(permissionIconValue);
            icon = in.readParcelable(Bitmap.class.getClassLoader());
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public PermissionIconEnum getPermissionIcon() {
            return permissionIcon;
        }

        public void setPermissionIcon(PermissionIconEnum permissionIcon) {
            this.permissionIcon = permissionIcon;
        }

        public Bitmap getIcon() {
            return icon;
        }

        public void setIcon(Bitmap icon) {
            this.icon = icon;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            String permissionIconValue = permissionIcon!=null? permissionIcon.name() : null;
            parcel.writeString(title);
            parcel.writeString(description);
            parcel.writeString(permissionIconValue);
            parcel.writeParcelable(icon, i);

        }

        public enum PermissionIconEnum implements Parcelable {
            TELEPHONE,
            LOCATION,
            MESSAGES;

            public static final Creator<PermissionIconEnum> CREATOR = new Creator<PermissionIconEnum>() {
                @Override
                public PermissionIconEnum createFromParcel(Parcel in) {
                    if (in.readInt() != -1 && in.readInt() < PermissionIconEnum.values().length) {
                        return PermissionIconEnum.values()[in.readInt()];
                    } else {
                        return null;
                    }
                }

                @Override
                public PermissionIconEnum[] newArray(int size) {
                    return new PermissionIconEnum[size];
                }
            };


            private PermissionIconEnum(Parcel in) {
            }

            PermissionIconEnum() {

            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
            }

            @Override
            public int describeContents() {
                return 0;
            }
        }
    }
}
