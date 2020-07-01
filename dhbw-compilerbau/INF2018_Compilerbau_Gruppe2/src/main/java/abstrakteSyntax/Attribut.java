package abstrakteSyntax;

public class Attribut
{
	public String name;
	public String type;

	@Override
	public boolean equals(Object o)
	{
		if ( this == o )
		{
			return true;
		}

		Attribut attribut = (Attribut) o;
		return name.equals(attribut.name) && type.equals(attribut.type);
	}

}
