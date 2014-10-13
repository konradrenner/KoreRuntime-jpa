/*
 * Copyright (C) 2014 Konrad Renner.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package org.kore.runtime.jpa.converter;

import java.util.Currency;
import javax.persistence.AttributeConverter;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Konrad Renner
 */
public class CurrencyConverterTest {

    private AttributeConverter<Currency, String> theConverter;
    private Currency euro;

    @Before
    public void setUp() {
        theConverter = new CurrencyConverter();
        euro = Currency.getInstance("EUR");
    }

    @Test
    public void testConvertToDatabaseColumn() {
        assertThat(theConverter.convertToDatabaseColumn(euro), is("EUR"));
    }
    
    @Test
    public void testConvertToDatabaseColumnNull() {

        assertThat(theConverter.convertToDatabaseColumn(null), is(nullValue()));
    }

    @Test
    public void testConvertToEntityAttribute() {
        assertThat(theConverter.convertToEntityAttribute("EUR"), is(euro));
    }
    
    @Test
    public void testConvertToEntityAttributeNull() {
        assertThat(theConverter.convertToEntityAttribute(null), is(nullValue()));
    }
}
