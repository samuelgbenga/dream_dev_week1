package mondayTwentyThreeAssessment.findzone;

public class GeopoliticalFinder {

    public static void main(String[] args) {

    }


    static Zone getZone(String state) {
        return switch (state.trim().toLowerCase()) {
            case "benue", "fct", "kogi",
                 "kwara", "nasarawa", "niger", "plateau" -> Zone.NORTH_CENTRAL;

            case "adamawa", "bauchi", "borno",
                 "gombe", "taraba", "yobe" -> Zone.NORTH_EAST;

            case "kaduna", "katsina", "kano",
                 "kebbi", "sokoto", "jigawa", "zamfara" -> Zone.NORTH_WEST;

            case "abia", "anambra", "ebonyi",
                 "enugu", "imo" -> Zone.SOUTH_EAST;

            case "akwa-ibom", "bayelsa", "cross-river",
                 "delta", "edo", "rivers" -> Zone.SOUTH_SOUTH;

            case "ekiti", "lagos", "osun",
                 "ondo", "ogun", "oyo" -> Zone.SOUTH_WEST;

            default -> Zone.UNKNOWN;
        };
    }
}
