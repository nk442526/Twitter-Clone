/**
 * This class is generated by jOOQ
 */
package first_project.helix;

/**
 * This class is generated by jOOQ.
 *
 * Convenience access to all sequences in public
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

	/**
	 * The sequence <code>public.member_id_seq</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> MEMBER_ID_SEQ = new org.jooq.impl.SequenceImpl<java.lang.Long>("member_id_seq", first_project.helix.Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.tweet_id_seq</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> TWEET_ID_SEQ = new org.jooq.impl.SequenceImpl<java.lang.Long>("tweet_id_seq", first_project.helix.Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
