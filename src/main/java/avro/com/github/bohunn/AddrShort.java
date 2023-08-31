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
public class AddrShort extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -725202014652220481L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AddrShort\",\"namespace\":\"avro.com.github.bohunn\",\"fields\":[{\"name\":\"objId\",\"type\":\"long\"},{\"name\":\"addrFull\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AddrShort> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AddrShort> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AddrShort> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AddrShort> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AddrShort> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AddrShort to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AddrShort from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AddrShort instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AddrShort fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private long objId;
  private java.lang.String addrFull;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AddrShort() {}

  /**
   * All-args constructor.
   * @param objId The new value for objId
   * @param addrFull The new value for addrFull
   */
  public AddrShort(java.lang.Long objId, java.lang.String addrFull) {
    this.objId = objId;
    this.addrFull = addrFull;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return objId;
    case 1: return addrFull;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: objId = (java.lang.Long)value$; break;
    case 1: addrFull = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'objId' field.
   * @return The value of the 'objId' field.
   */
  public long getObjId() {
    return objId;
  }


  /**
   * Sets the value of the 'objId' field.
   * @param value the value to set.
   */
  public void setObjId(long value) {
    this.objId = value;
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
   * Creates a new AddrShort RecordBuilder.
   * @return A new AddrShort RecordBuilder
   */
  public static avro.com.github.bohunn.AddrShort.Builder newBuilder() {
    return new avro.com.github.bohunn.AddrShort.Builder();
  }

  /**
   * Creates a new AddrShort RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AddrShort RecordBuilder
   */
  public static avro.com.github.bohunn.AddrShort.Builder newBuilder(avro.com.github.bohunn.AddrShort.Builder other) {
    if (other == null) {
      return new avro.com.github.bohunn.AddrShort.Builder();
    } else {
      return new avro.com.github.bohunn.AddrShort.Builder(other);
    }
  }

  /**
   * Creates a new AddrShort RecordBuilder by copying an existing AddrShort instance.
   * @param other The existing instance to copy.
   * @return A new AddrShort RecordBuilder
   */
  public static avro.com.github.bohunn.AddrShort.Builder newBuilder(avro.com.github.bohunn.AddrShort other) {
    if (other == null) {
      return new avro.com.github.bohunn.AddrShort.Builder();
    } else {
      return new avro.com.github.bohunn.AddrShort.Builder(other);
    }
  }

  /**
   * RecordBuilder for AddrShort instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AddrShort>
    implements org.apache.avro.data.RecordBuilder<AddrShort> {

    private long objId;
    private java.lang.String addrFull;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(avro.com.github.bohunn.AddrShort.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.objId)) {
        this.objId = data().deepCopy(fields()[0].schema(), other.objId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.addrFull)) {
        this.addrFull = data().deepCopy(fields()[1].schema(), other.addrFull);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing AddrShort instance
     * @param other The existing instance to copy.
     */
    private Builder(avro.com.github.bohunn.AddrShort other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.objId)) {
        this.objId = data().deepCopy(fields()[0].schema(), other.objId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.addrFull)) {
        this.addrFull = data().deepCopy(fields()[1].schema(), other.addrFull);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'objId' field.
      * @return The value.
      */
    public long getObjId() {
      return objId;
    }


    /**
      * Sets the value of the 'objId' field.
      * @param value The value of 'objId'.
      * @return This builder.
      */
    public avro.com.github.bohunn.AddrShort.Builder setObjId(long value) {
      validate(fields()[0], value);
      this.objId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'objId' field has been set.
      * @return True if the 'objId' field has been set, false otherwise.
      */
    public boolean hasObjId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'objId' field.
      * @return This builder.
      */
    public avro.com.github.bohunn.AddrShort.Builder clearObjId() {
      fieldSetFlags()[0] = false;
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
    public avro.com.github.bohunn.AddrShort.Builder setAddrFull(java.lang.String value) {
      validate(fields()[1], value);
      this.addrFull = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'addrFull' field has been set.
      * @return True if the 'addrFull' field has been set, false otherwise.
      */
    public boolean hasAddrFull() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'addrFull' field.
      * @return This builder.
      */
    public avro.com.github.bohunn.AddrShort.Builder clearAddrFull() {
      addrFull = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AddrShort build() {
      try {
        AddrShort record = new AddrShort();
        record.objId = fieldSetFlags()[0] ? this.objId : (java.lang.Long) defaultValue(fields()[0]);
        record.addrFull = fieldSetFlags()[1] ? this.addrFull : (java.lang.String) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AddrShort>
    WRITER$ = (org.apache.avro.io.DatumWriter<AddrShort>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AddrShort>
    READER$ = (org.apache.avro.io.DatumReader<AddrShort>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.objId);

    out.writeString(this.addrFull);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.objId = in.readLong();

      this.addrFull = in.readString();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.objId = in.readLong();
          break;

        case 1:
          this.addrFull = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










