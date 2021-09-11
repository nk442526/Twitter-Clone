/**
 * This class is generated by jOOQ
 */
package first_project.helix.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Coders extends org.jooq.impl.TableImpl<first_project.helix.tables.records.CodersRecord> {

	private static final long serialVersionUID = -1211496288;

	/**
	 * The singleton instance of <code>public.coders</code>
	 */
	public static final first_project.helix.tables.Coders CODERS = new first_project.helix.tables.Coders();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<first_project.helix.tables.records.CodersRecord> getRecordType() {
		return first_project.helix.tables.records.CodersRecord.class;
	}

	/**
	 * The column <code>public.coders.name</code>.
	 */
	public final org.jooq.TableField<first_project.helix.tables.records.CodersRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * The column <code>public.coders.age</code>.
	 */
	public final org.jooq.TableField<first_project.helix.tables.records.CodersRecord, java.lang.Long> AGE = createField("age", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * Create a <code>public.coders</code> table reference
	 */
	public Coders() {
		this("coders", null);
	}

	/**
	 * Create an aliased <code>public.coders</code> table reference
	 */
	public Coders(java.lang.String alias) {
		this(alias, first_project.helix.tables.Coders.CODERS);
	}

	private Coders(java.lang.String alias, org.jooq.Table<first_project.helix.tables.records.CodersRecord> aliased) {
		this(alias, aliased, null);
	}

	private Coders(java.lang.String alias, org.jooq.Table<first_project.helix.tables.records.CodersRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, first_project.helix.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public first_project.helix.tables.Coders as(java.lang.String alias) {
		return new first_project.helix.tables.Coders(alias, this);
	}

	/**
	 * Rename this table
	 */
	public first_project.helix.tables.Coders rename(java.lang.String name) {
		return new first_project.helix.tables.Coders(name, null);
	}
}
