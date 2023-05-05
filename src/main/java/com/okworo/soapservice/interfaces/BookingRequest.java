//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.05 at 03:33:34 PM EAT 
//


package com.okworo.soapservice.interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="booking" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="roomId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="checkinDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="checkoutDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clientId",
    "booking"
})
@XmlRootElement(name = "BookingRequest")
public class BookingRequest {

    protected long clientId;
    @XmlElement(required = true)
    protected List<BookingRequest.Booking> booking;

    /**
     * Gets the value of the clientId property.
     * 
     */
    public long getClientId() {
        return clientId;
    }

    /**
     * Sets the value of the clientId property.
     * 
     */
    public void setClientId(long value) {
        this.clientId = value;
    }

    /**
     * Gets the value of the booking property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the booking property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBooking().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BookingRequest.Booking }
     * 
     * 
     */
    public List<BookingRequest.Booking> getBooking() {
        if (booking == null) {
            booking = new ArrayList<BookingRequest.Booking>();
        }
        return this.booking;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="roomId" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="checkinDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="checkoutDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "roomId",
        "checkinDate",
        "checkoutDate"
    })
    public static class Booking {

        protected long roomId;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar checkinDate;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar checkoutDate;

        /**
         * Gets the value of the roomId property.
         * 
         */
        public long getRoomId() {
            return roomId;
        }

        /**
         * Sets the value of the roomId property.
         * 
         */
        public void setRoomId(long value) {
            this.roomId = value;
        }

        /**
         * Gets the value of the checkinDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCheckinDate() {
            return checkinDate;
        }

        /**
         * Sets the value of the checkinDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCheckinDate(XMLGregorianCalendar value) {
            this.checkinDate = value;
        }

        /**
         * Gets the value of the checkoutDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCheckoutDate() {
            return checkoutDate;
        }

        /**
         * Sets the value of the checkoutDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCheckoutDate(XMLGregorianCalendar value) {
            this.checkoutDate = value;
        }

    }

}