package Models;

public class Species {
    // Variables:
    private int speciesID;
    private String scientificName, commonName, family, regionOrigin, lifeCycle;

    /**
     * Constructor for Species
     * @param speciesID The index number
     * @param scientificName The scientific name
     * @param commonName The common name
     * @param family The organic family
     * @param regionOrigin Where it originated
     * @param lifeCycle Is it perennial or annual
     */
    public Species(int speciesID, String scientificName, String commonName, String family, String regionOrigin, String lifeCycle) {
        setSpeciesID(speciesID);
        setScientificName(scientificName);
        setCommonName(commonName);
        setFamily(family);
        setRegionOrigin(regionOrigin);
        setLifeCycle(lifeCycle);
    }

    public int getSpeciesID() {
        return speciesID;
    }

    /**
     * SpeciesID must be 0 or higher
     * @param speciesID index number
     */
    public void setSpeciesID(int speciesID) {
        if (speciesID >= 0)
            this.speciesID = speciesID;
        else
            throw new IllegalArgumentException("ID cannot be negative");

    }

    public String getScientificName() {
        return scientificName;
    }

    /**
     * Scientific name cannot be blank
     * @param scientificName scientific name
     */
    public void setScientificName(String scientificName) {
        if (!scientificName.isBlank())
            this.scientificName = scientificName;
        else
            throw new IllegalArgumentException("Please specify a scientific name");
    }

    public String getCommonName() {
        return commonName;
    }

    /**
     * Common name cannot be blank
     * @param commonName common name
     */
    public void setCommonName(String commonName) {
        if (!commonName.isBlank())
            this.commonName = commonName;
        else
            throw new IllegalArgumentException("Please specify a common name");
    }

    public String getFamily() {
        return family;
    }

    /**
     * Family cannot be blank
     * @param family organic family
     */
    public void setFamily(String family) {
        if (!family.isBlank())
            this.family = family;
        else
            throw new IllegalArgumentException("Please specify a family");
    }

    public String getRegionOrigin() {
        return regionOrigin;
    }

    /**
     * Region cannot be blank
     * @param regionOrigin area it originated
     */
    public void setRegionOrigin(String regionOrigin) {
        if (!regionOrigin.isBlank())
            this.regionOrigin = regionOrigin;
        else
            throw new IllegalArgumentException("Please specify a region of origin.");
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    /**
     * Life Cycle can be blank, annual or perennial
     * @param lifeCycle annual, perennial, unknown
     */
    public void setLifeCycle(String lifeCycle) {

        if (lifeCycle.equalsIgnoreCase("annual") || lifeCycle.equalsIgnoreCase("perennial"))
                this.lifeCycle = lifeCycle;
        else
            this.lifeCycle = "unknown";
    }
}
