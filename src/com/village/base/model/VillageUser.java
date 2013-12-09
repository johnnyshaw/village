package com.village.base.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="VILLAGE_USER")
public class VillageUser extends BaseModel implements Serializable{
	
	private Integer cractUnid;
	
	private String cractUuid;
	
	private String cractCrorgUuid;
	
	private String cractSimpleCode;
	
	private String cractPassword;
	
	private String cractName;
	

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name="CRACT_UNID",strategy="")
	@Column(name="CRACT_UNID")
	public Integer getCractUnid() {
		return cractUnid;
	}

	public void setCractUnid(Integer cractUnid) {
		this.cractUnid = cractUnid;
	}

	@Column(name="CRACT_UUID")
	public String getCractUuid() {
		return cractUuid;
	}

	public void setCractUuid(String cractUuid) {
		this.cractUuid = cractUuid;
	}

	@Column(name="CRACT_CRORG_UUID")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")  
	public String getCractCrorgUuid() {
		return cractCrorgUuid;
	}

	public void setCractCrorgUuid(String cractCrorgUuid) {
		this.cractCrorgUuid = cractCrorgUuid;
	}

	@Column(name="CRACT_SIMPLE_CODE")
	public String getCractSimpleCode() {
		return cractSimpleCode;
	}

	public void setCractSimpleCode(String cractSimpleCode) {
		this.cractSimpleCode = cractSimpleCode;
	}

	@Column(name="CRACT_PASSWORD")
	public String getCractPassword() {
		return cractPassword;
	}

	public void setCractPassword(String cractPassword) {
		this.cractPassword = cractPassword;
	}

	@Column(name="CRACT_NAME")
	public String getCractName() {
		return cractName;
	}

	public void setCractName(String cractName) {
		this.cractName = cractName;
	}
}
