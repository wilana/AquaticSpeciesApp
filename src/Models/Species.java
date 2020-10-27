package Models;



public class Species {
    private int speciesID;
    private String scientificName, commonName, family, regionOrigin, lifeCycle;

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

    public void setSpeciesID(int speciesID) {
        if (speciesID >= 0) {
            this.speciesID = speciesID;
        }
        else {
            throw new IllegalArgumentException("ID cannot be negative");
        }
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        if (!scientificName.isBlank()) {
            this.scientificName = scientificName;
        }
        else {
            throw new IllegalArgumentException("Please specify a scientific name");
        }
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        if (!commonName.isBlank()) {
            this.commonName = commonName;
        }
        else
        {
            throw new IllegalArgumentException("Please specify a common name");
        }
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getRegionOrigin() {
        return regionOrigin;
    }

    public void setRegionOrigin(String regionOrigin) {
        if (!regionOrigin.isBlank())
        {
            this.regionOrigin = regionOrigin;
        }
        else
        {
            throw new IllegalArgumentException("Please specify a region of origin.");
        }
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        if (!lifeCycle.isBlank())
        {
            this.lifeCycle = lifeCycle;
        }
        else
        {
            throw new IllegalArgumentException("Please specify a life cycle");
        }
    }
}
