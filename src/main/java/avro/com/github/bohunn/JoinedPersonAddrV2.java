/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package avro.com.github.bohunn;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class JoinedPersonAddrV2 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7793891622861610026L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"JoinedPersonAddrV2\",\"namespace\":\"avro.com.github.bohunn\",\"fields\":[{\"name\":\"objPersonId\",\"type\":\"long\",\"doc\":\"obj person id\"},{\"name\":\"objAddrId\",\"type\":\"long\",\"doc\":\"obj addr id\"},{\"name\":\"personName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"personNr\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"obj_person key id 807\"},{\"name\":\"domiAddrId\",\"type\":\"long\"},{\"name\":\"narilo\",\"type\":\"boolean\"},{\"name\":\"isBoeko\",\"type\":\"boolean\"},{\"name\":\"legalHold\",\"type\":\"boolean\"},{\"name\":\"addrFull\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"closeDate\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"force\",\"type\":\"int\",\"doc\":\"technical field to force onbase synchronization\"},{\"name\":\"isEmittent\",\"type\":\"boolean\",\"default\":false},{\"name\":\"hash\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<JoinedPersonAddrV2> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<JoinedPersonAddrV2> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<JoinedPersonAddrV2> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<JoinedPersonAddrV2> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<JoinedPersonAddrV2> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this JoinedPersonAddrV2 to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a JoinedPersonAddrV2 from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a JoinedPersonAddrV2 instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static JoinedPersonAddrV2 fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** obj person id */
  private long objPersonId;
  /** obj addr id */
  private long objAddrId;
  private java.lang.String personName;
  /** obj_person key id 807 */
  private java.lang.String personNr;
  private long domiAddrId;
  private boolean narilo;
  private boolean isBoeko;
  private boolean legalHold;
  private java.lang.String addrFull;
  private java.lang.String closeDate;
  /** technical field to force onbase synchronization */
  private int force;
  private boolean isEmittent;
  private java.lang.String hash;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public JoinedPersonAddrV2() {}

  /**
   * All-args constructor.
   * @param objPersonId obj person id
   * @param objAddrId obj addr id
   * @param personName The new value for personName
   * @param personNr obj_person key id 807
   * @param domiAddrId The new value for domiAddrId
   * @param narilo The new value for narilo
   * @param isBoeko The new value for isBoeko
   * @param legalHold The new value for legalHold
   * @param addrFull The new value for addrFull
   * @param closeDate The new value for closeDate
   * @param force technical field to force onbase synchronization
   * @param isEmittent The new value for isEmittent
   * @param hash The new value for hash
   */
  public JoinedPersonAddrV2(java.lang.Long objPersonId, java.lang.Long objAddrId, java.lang.String personName, java.lang.String personNr, java.lang.Long domiAddrId, java.lang.Boolean narilo, java.lang.Boolean isBoeko, java.lang.Boolean legalHold, java.lang.String addrFull, java.lang.String closeDate, java.lang.Integer force, java.lang.Boolean isEmittent, java.lang.String hash) {
    this.objPersonId = objPersonId;
    this.objAddrId = objAddrId;
    this.personName = personName;
    this.personNr = personNr;
    this.domiAddrId = domiAddrId;
    this.narilo = narilo;
    this.isBoeko = isBoeko;
    this.legalHold = legalHold;
    this.addrFull = addrFull;
    this.closeDate = closeDate;
    this.force = force;
    this.isEmittent = isEmittent;
    this.hash = hash;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return objPersonId;
    case 1: return objAddrId;
    case 2: return personName;
    case 3: return personNr;
    case 4: return domiAddrId;
    case 5: return narilo;
    case 6: return isBoeko;
    case 7: return legalHold;
    case 8: return addrFull;
    case 9: return closeDate;
    case 10: return force;
    case 11: return isEmittent;
    case 12: return hash;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: objPersonId = (java.lang.Long)value$; break;
    case 1: objAddrId = (java.lang.Long)value$; break;
    case 2: personName = value$ != null ? value$.toString() : null; break;
    case 3: personNr = value$ != null ? value$.toString() : null; break;
    case 4: domiAddrId = (java.lang.Long)value$; break;
    case 5: narilo = (java.lang.Boolean)value$; break;
    case 6: isBoeko = (java.lang.Boolean)value$; break;
    case 7: legalHold = (java.lang.Boolean)value$; break;
    case 8: addrFull = value$ != null ? value$.toString() : null; break;
    case 9: closeDate = value$ != null ? value$.toString() : null; break;
    case 10: force = (java.lang.Integer)value$; break;
    case 11: isEmittent = (java.lang.Boolean)value$; break;
    case 12: hash = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'objPersonId' field.
   * @return obj person id
   */
  public long getObjPersonId() {
    return objPersonId;
  }


  /**
   * Sets the value of the 'objPersonId' field.
   * obj person id
   * @param value the value to set.
   */
  public void setObjPersonId(long value) {
    this.objPersonId = value;
  }

  /**
   * Gets the value of the 'objAddrId' field.
   * @return obj addr id
   */
  public long getObjAddrId() {
    return objAddrId;
  }


  /**
   * Sets the value of the 'objAddrId' field.
   * obj addr id
   * @param value the value to set.
   */
  public void setObjAddrId(long value) {
    this.objAddrId = value;
  }

  /**
   * Gets the value of the 'personName' field.
   * @return The value of the 'personName' field.
   */
  public java.lang.String getPersonName() {
    return personName;
  }


  /**
   * Sets the value of the 'personName' field.
   * @param value the value to set.
   */
  public void setPersonName(java.lang.String value) {
    this.personName = value;
  }

  /**
   * Gets the value of the 'personNr' field.
   * @return obj_person key id 807
   */
  public java.lang.String getPersonNr() {
    return personNr;
  }


  /**
   * Sets the value of the 'personNr' field.
   * obj_person key id 807
   * @param value the value to set.
   */
  public void setPersonNr(java.lang.String value) {
    this.personNr = value;
  }

  /**
   * Gets the value of the 'domiAddrId' field.
   * @return The value of the 'domiAddrId' field.
   */
  public long getDomiAddrId() {
    return domiAddrId;
  }


  /**
   * Sets the value of the 'domiAddrId' field.
   * @param value the value to set.
   */
  public void setDomiAddrId(long value) {
    this.domiAddrId = value;
  }

  /**
   * Gets the value of the 'narilo' field.
   * @return The value of the 'narilo' field.
   */
  public boolean getNarilo() {
    return narilo;
  }


  /**
   * Sets the value of the 'narilo' field.
   * @param value the value to set.
   */
  public void setNarilo(boolean value) {
    this.narilo = value;
  }

  /**
   * Gets the value of the 'isBoeko' field.
   * @return The value of the 'isBoeko' field.
   */
  public boolean getIsBoeko() {
    return isBoeko;
  }


  /**
   * Sets the value of the 'isBoeko' field.
   * @param value the value to set.
   */
  public void setIsBoeko(boolean value) {
    this.isBoeko = value;
  }

  /**
   * Gets the value of the 'legalHold' field.
   * @return The value of the 'legalHold' field.
   */
  public boolean getLegalHold() {
    return legalHold;
  }


  /**
   * Sets the value of the 'legalHold' field.
   * @param value the value to set.
   */
  public void setLegalHold(boolean value) {
    this.legalHold = value;
  }

  /**
   * Gets the value of the 'addrFull' field.
   * @return The value of the 'addrFull' field.
   */
  public java.lang.String getAddrFull() {
    return addrFull;
  }


  /**
   * Sets the value of the 'addrFull' field.
   * @param value the value to set.
   */
  public void setAddrFull(java.lang.String value) {
    this.addrFull = value;
  }

  /**
   * Gets the value of the 'closeDate' field.
   * @return The value of the 'closeDate' field.
   */
  public java.lang.String getCloseDate() {
    return closeDate;
  }


  /**
   * Sets the value of the 'closeDate' field.
   * @param value the value to set.
   */
  public void setCloseDate(java.lang.String value) {
    this.closeDate = value;
  }

  /**
   * Gets the value of the 'force' field.
   * @return technical field to force onbase synchronization
   */
  public int getForce() {
    return force;
  }


  /**
   * Sets the value of the 'force' field.
   * technical field to force onbase synchronization
   * @param value the value to set.
   */
  public void setForce(int value) {
    this.force = value;
  }

  /**
   * Gets the value of the 'isEmittent' field.
   * @return The value of the 'isEmittent' field.
   */
  public boolean getIsEmittent() {
    return isEmittent;
  }


  /**
   * Sets the value of the 'isEmittent' field.
   * @param value the value to set.
   */
  public void setIsEmittent(boolean value) {
    this.isEmittent = value;
  }

  /**
   * Gets the value of the 'hash' field.
   * @return The value of the 'hash' field.
   */
  public java.lang.String getHash() {
    return hash;
  }


  /**
   * Sets the value of the 'hash' field.
   * @param value the value to set.
   */
  public void setHash(java.lang.String value) {
    this.hash = value;
  }

  /**
   * Creates a new JoinedPersonAddrV2 RecordBuilder.
   * @return A new JoinedPersonAddrV2 RecordBuilder
   */
  public static avro.com.github.bohunn.JoinedPersonAddrV2.Builder newBuilder() {
    return new avro.com.github.bohunn.JoinedPersonAddrV2.Builder();
  }

  /**
   * Creates a new JoinedPersonAddrV2 RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new JoinedPersonAddrV2 RecordBuilder
   */
  public static avro.com.github.bohunn.JoinedPersonAddrV2.Builder newBuilder(avro.com.github.bohunn.JoinedPersonAddrV2.Builder other) {
    if (other == null) {
      return new avro.com.github.bohunn.JoinedPersonAddrV2.Builder();
    } else {
      return new avro.com.github.bohunn.JoinedPersonAddrV2.Builder(other);
    }
  }

  /**
   * Creates a new JoinedPersonAddrV2 RecordBuilder by copying an existing JoinedPersonAddrV2 instance.
   * @param other The existing instance to copy.
   * @return A new JoinedPersonAddrV2 RecordBuilder
   */
  public static avro.com.github.bohunn.JoinedPersonAddrV2.Builder newBuilder(avro.com.github.bohunn.JoinedPersonAddrV2 other) {
    if (other == null) {
      return new avro.com.github.bohunn.JoinedPersonAddrV2.Builder();
    } else {
      return new avro.com.github.bohunn.JoinedPersonAddrV2.Builder(other);
    }
  }

  /**
   * RecordBuilder for JoinedPersonAddrV2 instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<JoinedPersonAddrV2>
    implements org.apache.avro.data.RecordBuilder<JoinedPersonAddrV2> {

    /** obj person id */
    private long objPersonId;
    /** obj addr id */
    private long objAddrId;
    private java.lang.String personName;
    /** obj_person key id 807 */
    private java.lang.String personNr;
    private long domiAddrId;
    private boolean narilo;
    private boolean isBoeko;
    private boolean legalHold;
    private java.lang.String addrFull;
    private java.lang.String closeDate;
    /** technical field to force onbase synchronization */
    private int force;
    private boolean isEmittent;
    private java.lang.String hash;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(avro.com.github.bohunn.JoinedPersonAddrV2.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.objPersonId)) {
        this.objPersonId = data().deepCopy(fields()[0].schema(), other.objPersonId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.objAddrId)) {
        this.objAddrId = data().deepCopy(fields()[1].schema(), other.objAddrId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.personName)) {
        this.personName = data().deepCopy(fields()[2].schema(), other.personName);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.personNr)) {
        this.personNr = data().deepCopy(fields()[3].schema(), other.personNr);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.domiAddrId)) {
        this.domiAddrId = data().deepCopy(fields()[4].schema(), other.domiAddrId);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.narilo)) {
        this.narilo = data().deepCopy(fields()[5].schema(), other.narilo);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.isBoeko)) {
        this.isBoeko = data().deepCopy(fields()[6].schema(), other.isBoeko);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.legalHold)) {
        this.legalHold = data().deepCopy(fields()[7].schema(), other.legalHold);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.addrFull)) {
        this.addrFull = data().deepCopy(fields()[8].schema(), other.addrFull);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (isValidValue(fields()[9], other.closeDate)) {
        this.closeDate = data().deepCopy(fields()[9].schema(), other.closeDate);
        fieldSetFlags()[9] = other.fieldSetFlags()[9];
      }
      if (isValidValue(fields()[10], other.force)) {
        this.force = data().deepCopy(fields()[10].schema(), other.force);
        fieldSetFlags()[10] = other.fieldSetFlags()[10];
      }
      if (isValidValue(fields()[11], other.isEmittent)) {
        this.isEmittent = data().deepCopy(fields()[11].schema(), other.isEmittent);
        fieldSetFlags()[11] = other.fieldSetFlags()[11];
      }
      if (isValidValue(fields()[12], other.hash)) {
        this.hash = data().deepCopy(fields()[12].schema(), other.hash);
        fieldSetFlags()[12] = other.fieldSetFlags()[12];
      }
    }

    /**
     * Creates a Builder by copying an existing JoinedPersonAddrV2 instance
     * @param other The existing instance to copy.
     */
    private Builder(avro.com.github.bohunn.JoinedPersonAddrV2 other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.objPersonId)) {
        this.objPersonId = data().deepCopy(fields()[0].schema(), other.objPersonId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.objAddrId)) {
        this.objAddrId = data().deepCopy(fields()[1].schema(), other.objAddrId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.personName)) {
        this.personName = data().deepCopy(fields()[2].schema(), other.personName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.personNr)) {
        this.personNr = data().deepCopy(fields()[3].schema(), other.personNr);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.domiAddrId)) {
        this.domiAddrId = data().deepCopy(fields()[4].schema(), other.domiAddrId);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.narilo)) {
        this.narilo = data().deepCopy(fields()[5].schema(), other.narilo);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.isBoeko)) {
        this.isBoeko = data().deepCopy(fields()[6].schema(), other.isBoeko);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.legalHold)) {
        this.legalHold = data().deepCopy(fields()[7].schema(), other.legalHold);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.addrFull)) {
        this.addrFull = data().deepCopy(fields()[8].schema(), other.addrFull);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.closeDate)) {
        this.closeDate = data().deepCopy(fields()[9].schema(), other.closeDate);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.force)) {
        this.force = data().deepCopy(fields()[10].schema(), other.force);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.isEmittent)) {
        this.isEmittent = data().deepCopy(fields()[11].schema(), other.isEmittent);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.hash)) {
        this.hash = data().deepCopy(fields()[12].schema(), other.hash);
        fieldSetFlags()[12] = true;
      }
    }

    /**
      * Gets the value of the 'objPersonId' field.
      * obj person id
      * @return The value.
      */
    public long getObjPersonId() {
      return objPersonId;
    }


    /**
      * Sets the value of the 'objPersonId' field.
      * obj person id
      * @param value The value of 'objPersonId'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setObjPersonId(long value) {
      validate(fields()[0], value);
      this.objPersonId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'objPersonId' field has been set.
      * obj person id
      * @return True if the 'objPersonId' field has been set, false otherwise.
      */
    public boolean hasObjPersonId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'objPersonId' field.
      * obj person id
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearObjPersonId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'objAddrId' field.
      * obj addr id
      * @return The value.
      */
    public long getObjAddrId() {
      return objAddrId;
    }


    /**
      * Sets the value of the 'objAddrId' field.
      * obj addr id
      * @param value The value of 'objAddrId'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setObjAddrId(long value) {
      validate(fields()[1], value);
      this.objAddrId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'objAddrId' field has been set.
      * obj addr id
      * @return True if the 'objAddrId' field has been set, false otherwise.
      */
    public boolean hasObjAddrId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'objAddrId' field.
      * obj addr id
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearObjAddrId() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'personName' field.
      * @return The value.
      */
    public java.lang.String getPersonName() {
      return personName;
    }


    /**
      * Sets the value of the 'personName' field.
      * @param value The value of 'personName'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setPersonName(java.lang.String value) {
      validate(fields()[2], value);
      this.personName = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'personName' field has been set.
      * @return True if the 'personName' field has been set, false otherwise.
      */
    public boolean hasPersonName() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'personName' field.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearPersonName() {
      personName = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'personNr' field.
      * obj_person key id 807
      * @return The value.
      */
    public java.lang.String getPersonNr() {
      return personNr;
    }


    /**
      * Sets the value of the 'personNr' field.
      * obj_person key id 807
      * @param value The value of 'personNr'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setPersonNr(java.lang.String value) {
      validate(fields()[3], value);
      this.personNr = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'personNr' field has been set.
      * obj_person key id 807
      * @return True if the 'personNr' field has been set, false otherwise.
      */
    public boolean hasPersonNr() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'personNr' field.
      * obj_person key id 807
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearPersonNr() {
      personNr = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'domiAddrId' field.
      * @return The value.
      */
    public long getDomiAddrId() {
      return domiAddrId;
    }


    /**
      * Sets the value of the 'domiAddrId' field.
      * @param value The value of 'domiAddrId'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setDomiAddrId(long value) {
      validate(fields()[4], value);
      this.domiAddrId = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'domiAddrId' field has been set.
      * @return True if the 'domiAddrId' field has been set, false otherwise.
      */
    public boolean hasDomiAddrId() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'domiAddrId' field.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearDomiAddrId() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'narilo' field.
      * @return The value.
      */
    public boolean getNarilo() {
      return narilo;
    }


    /**
      * Sets the value of the 'narilo' field.
      * @param value The value of 'narilo'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setNarilo(boolean value) {
      validate(fields()[5], value);
      this.narilo = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'narilo' field has been set.
      * @return True if the 'narilo' field has been set, false otherwise.
      */
    public boolean hasNarilo() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'narilo' field.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearNarilo() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'isBoeko' field.
      * @return The value.
      */
    public boolean getIsBoeko() {
      return isBoeko;
    }


    /**
      * Sets the value of the 'isBoeko' field.
      * @param value The value of 'isBoeko'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setIsBoeko(boolean value) {
      validate(fields()[6], value);
      this.isBoeko = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'isBoeko' field has been set.
      * @return True if the 'isBoeko' field has been set, false otherwise.
      */
    public boolean hasIsBoeko() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'isBoeko' field.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearIsBoeko() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'legalHold' field.
      * @return The value.
      */
    public boolean getLegalHold() {
      return legalHold;
    }


    /**
      * Sets the value of the 'legalHold' field.
      * @param value The value of 'legalHold'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setLegalHold(boolean value) {
      validate(fields()[7], value);
      this.legalHold = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'legalHold' field has been set.
      * @return True if the 'legalHold' field has been set, false otherwise.
      */
    public boolean hasLegalHold() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'legalHold' field.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearLegalHold() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'addrFull' field.
      * @return The value.
      */
    public java.lang.String getAddrFull() {
      return addrFull;
    }


    /**
      * Sets the value of the 'addrFull' field.
      * @param value The value of 'addrFull'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setAddrFull(java.lang.String value) {
      validate(fields()[8], value);
      this.addrFull = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'addrFull' field has been set.
      * @return True if the 'addrFull' field has been set, false otherwise.
      */
    public boolean hasAddrFull() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'addrFull' field.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearAddrFull() {
      addrFull = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'closeDate' field.
      * @return The value.
      */
    public java.lang.String getCloseDate() {
      return closeDate;
    }


    /**
      * Sets the value of the 'closeDate' field.
      * @param value The value of 'closeDate'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setCloseDate(java.lang.String value) {
      validate(fields()[9], value);
      this.closeDate = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'closeDate' field has been set.
      * @return True if the 'closeDate' field has been set, false otherwise.
      */
    public boolean hasCloseDate() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'closeDate' field.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearCloseDate() {
      closeDate = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'force' field.
      * technical field to force onbase synchronization
      * @return The value.
      */
    public int getForce() {
      return force;
    }


    /**
      * Sets the value of the 'force' field.
      * technical field to force onbase synchronization
      * @param value The value of 'force'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setForce(int value) {
      validate(fields()[10], value);
      this.force = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'force' field has been set.
      * technical field to force onbase synchronization
      * @return True if the 'force' field has been set, false otherwise.
      */
    public boolean hasForce() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'force' field.
      * technical field to force onbase synchronization
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearForce() {
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'isEmittent' field.
      * @return The value.
      */
    public boolean getIsEmittent() {
      return isEmittent;
    }


    /**
      * Sets the value of the 'isEmittent' field.
      * @param value The value of 'isEmittent'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setIsEmittent(boolean value) {
      validate(fields()[11], value);
      this.isEmittent = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'isEmittent' field has been set.
      * @return True if the 'isEmittent' field has been set, false otherwise.
      */
    public boolean hasIsEmittent() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'isEmittent' field.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearIsEmittent() {
      fieldSetFlags()[11] = false;
      return this;
    }

    /**
      * Gets the value of the 'hash' field.
      * @return The value.
      */
    public java.lang.String getHash() {
      return hash;
    }


    /**
      * Sets the value of the 'hash' field.
      * @param value The value of 'hash'.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder setHash(java.lang.String value) {
      validate(fields()[12], value);
      this.hash = value;
      fieldSetFlags()[12] = true;
      return this;
    }

    /**
      * Checks whether the 'hash' field has been set.
      * @return True if the 'hash' field has been set, false otherwise.
      */
    public boolean hasHash() {
      return fieldSetFlags()[12];
    }


    /**
      * Clears the value of the 'hash' field.
      * @return This builder.
      */
    public avro.com.github.bohunn.JoinedPersonAddrV2.Builder clearHash() {
      hash = null;
      fieldSetFlags()[12] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JoinedPersonAddrV2 build() {
      try {
        JoinedPersonAddrV2 record = new JoinedPersonAddrV2();
        record.objPersonId = fieldSetFlags()[0] ? this.objPersonId : (java.lang.Long) defaultValue(fields()[0]);
        record.objAddrId = fieldSetFlags()[1] ? this.objAddrId : (java.lang.Long) defaultValue(fields()[1]);
        record.personName = fieldSetFlags()[2] ? this.personName : (java.lang.String) defaultValue(fields()[2]);
        record.personNr = fieldSetFlags()[3] ? this.personNr : (java.lang.String) defaultValue(fields()[3]);
        record.domiAddrId = fieldSetFlags()[4] ? this.domiAddrId : (java.lang.Long) defaultValue(fields()[4]);
        record.narilo = fieldSetFlags()[5] ? this.narilo : (java.lang.Boolean) defaultValue(fields()[5]);
        record.isBoeko = fieldSetFlags()[6] ? this.isBoeko : (java.lang.Boolean) defaultValue(fields()[6]);
        record.legalHold = fieldSetFlags()[7] ? this.legalHold : (java.lang.Boolean) defaultValue(fields()[7]);
        record.addrFull = fieldSetFlags()[8] ? this.addrFull : (java.lang.String) defaultValue(fields()[8]);
        record.closeDate = fieldSetFlags()[9] ? this.closeDate : (java.lang.String) defaultValue(fields()[9]);
        record.force = fieldSetFlags()[10] ? this.force : (java.lang.Integer) defaultValue(fields()[10]);
        record.isEmittent = fieldSetFlags()[11] ? this.isEmittent : (java.lang.Boolean) defaultValue(fields()[11]);
        record.hash = fieldSetFlags()[12] ? this.hash : (java.lang.String) defaultValue(fields()[12]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<JoinedPersonAddrV2>
    WRITER$ = (org.apache.avro.io.DatumWriter<JoinedPersonAddrV2>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<JoinedPersonAddrV2>
    READER$ = (org.apache.avro.io.DatumReader<JoinedPersonAddrV2>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.objPersonId);

    out.writeLong(this.objAddrId);

    out.writeString(this.personName);

    out.writeString(this.personNr);

    out.writeLong(this.domiAddrId);

    out.writeBoolean(this.narilo);

    out.writeBoolean(this.isBoeko);

    out.writeBoolean(this.legalHold);

    if (this.addrFull == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.addrFull);
    }

    if (this.closeDate == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.closeDate);
    }

    out.writeInt(this.force);

    out.writeBoolean(this.isEmittent);

    out.writeString(this.hash);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.objPersonId = in.readLong();

      this.objAddrId = in.readLong();

      this.personName = in.readString();

      this.personNr = in.readString();

      this.domiAddrId = in.readLong();

      this.narilo = in.readBoolean();

      this.isBoeko = in.readBoolean();

      this.legalHold = in.readBoolean();

      if (in.readIndex() != 1) {
        in.readNull();
        this.addrFull = null;
      } else {
        this.addrFull = in.readString();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.closeDate = null;
      } else {
        this.closeDate = in.readString();
      }

      this.force = in.readInt();

      this.isEmittent = in.readBoolean();

      this.hash = in.readString();

    } else {
      for (int i = 0; i < 13; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.objPersonId = in.readLong();
          break;

        case 1:
          this.objAddrId = in.readLong();
          break;

        case 2:
          this.personName = in.readString();
          break;

        case 3:
          this.personNr = in.readString();
          break;

        case 4:
          this.domiAddrId = in.readLong();
          break;

        case 5:
          this.narilo = in.readBoolean();
          break;

        case 6:
          this.isBoeko = in.readBoolean();
          break;

        case 7:
          this.legalHold = in.readBoolean();
          break;

        case 8:
          if (in.readIndex() != 1) {
            in.readNull();
            this.addrFull = null;
          } else {
            this.addrFull = in.readString();
          }
          break;

        case 9:
          if (in.readIndex() != 1) {
            in.readNull();
            this.closeDate = null;
          } else {
            this.closeDate = in.readString();
          }
          break;

        case 10:
          this.force = in.readInt();
          break;

        case 11:
          this.isEmittent = in.readBoolean();
          break;

        case 12:
          this.hash = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










