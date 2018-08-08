package harvestCompany

/**
 * Created by danie_000 on 6/22/2015.
 */
class HarvestCompany {
    int id
    String name;

    static constraints = {
        id nullable:false,unique:true,blank:false
        name nullable: false, blank: false, maxSize: 50
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HarvestCompany){
			HarvestCompany harvestCompany = (HarvestCompany) obj
			if(harvestCompany.id == id){
				return true
			}
		}
		return false
	}
}
