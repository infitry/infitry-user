package com.infitry.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @since 2020. 3. 31.
 * @author leesw
 * @mail leesw504@gmail.com
 * @description : 유저 엔티티
 */
@Entity
@Table(name="INF_USER")
@Data
public class User {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USER_SEQ", nullable = false)
	private long userSeq;
	
	@Column(name = "ID", nullable = false, length = 50)
	private String id;
	
	@Column(name = "PASSWORD", nullable = false, length = 100)
	private String password;
	
	@Column(name = "NAME", nullable = false, length = 20)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REG_DATE", nullable = false)
	private Date regDate;
}
