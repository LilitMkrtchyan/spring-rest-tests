package com.test.recruitment.json;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * Transaction json representation
 *
 * @author lilitmk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UpdateTransactionRequest extends AbstractTransaction implements Serializable {
}