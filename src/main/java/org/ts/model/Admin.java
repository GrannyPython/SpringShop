package org.ts.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 Basic entity of the application
 Not realized functionality yet
 */

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "id")

public class Admin extends User {

    public Admin() {
    }


}
