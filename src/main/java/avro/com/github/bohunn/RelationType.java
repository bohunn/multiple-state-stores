/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package avro.com.github.bohunn;
/** RO - Registered Owner, AO - Account Owner, IO - Issuer */
@org.apache.avro.specific.AvroGenerated
public enum RelationType implements org.apache.avro.generic.GenericEnumSymbol<RelationType> {
  RO, AO, IO  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"RelationType\",\"namespace\":\"avro.com.github.bohunn\",\"doc\":\"RO - Registered Owner, AO - Account Owner, IO - Issuer\",\"symbols\":[\"RO\",\"AO\",\"IO\"],\"default\":\"AO\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}