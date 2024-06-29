package com.example.technikonproject.controller;

import com.example.technikonproject.domain.Property;
import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.mapper.BaseMapper;
import com.example.technikonproject.mapper.PropertyMapper;
import com.example.technikonproject.service.BaseService;
import com.example.technikonproject.service.PropertyService;
import com.example.technikonproject.transfer.ApiResponse;
import com.example.technikonproject.transfer.resource.property.PropertyResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@RestController
@RequiredArgsConstructor
@RequestMapping("/property")
public class PropertyController extends BaseController<Property, PropertyResource> {

    private final PropertyMapper propertyMapper;
    private final PropertyService propertyService;

    @Override
    protected BaseService<Property, Long> getBaseService() {
        return propertyService;
    }

    @Override
    protected BaseMapper<Property, PropertyResource> getMapper() {
        return propertyMapper;
    }

    @GetMapping(params = {"tin"})
    public ResponseEntity<ApiResponse<List<PropertyResource>>> findByTin(@RequestParam Long tin) {
        return ResponseEntity.ok(
                ApiResponse.<List<PropertyResource>>builder().data(getMapper().toResources(propertyService.findPropertiesByTin(tin)))
                        .build());
    }

    @GetMapping(params = {"e9"})
    public ResponseEntity<ApiResponse<PropertyResource>> findByE9(@RequestParam Long e9) {
        return ResponseEntity.ok(
                ApiResponse.<PropertyResource>builder().data(getMapper().toResource(propertyService.readProperty(e9)))
                        .build());
    }

    @GetMapping("count")
    public ResponseEntity<ApiResponse<Long>> countAllUsers() {
        return ResponseEntity.ok(
                ApiResponse.<Long>builder().data((propertyService.count()))
                        .build());
    }

    @PostMapping("sendEmail")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendEmail(@RequestBody WebUser user){
        sendEmail(user.getEmail(), "Property Created", "You just created a property");
    }

    // Method to send email
    private void sendEmail(String to, String subject, String body) {
        // Sender's email ID needs to be mentioned
        String from = "Technikon@gg.com"; // change accordingly

        // Assuming you are sending email through localhost
        String host = "20.188.44.4"; // Mailhog SMTP server

        Properties props = new Properties();
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "1025");

        // Get the Session object
        Session session = Session.getInstance(props);

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(body);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
