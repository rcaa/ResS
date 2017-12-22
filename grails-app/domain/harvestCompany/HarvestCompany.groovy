package harvestCompany

/**
 * Created by danie_000 on 6/22/2015.
 */
class HarvestCompany {
    int id
    String name;

    static constraints = {
        id nullable:false,unique:true,blank:false
        name nullable: false, blank: false
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HarvestCompany other = (HarvestCompany) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String toString() {
		return "ID: $id, Nome Da Companhia: $name"
		}
}
