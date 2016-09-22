package com.bankstructure.services;

import java.io.Serializable;

public class Module implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
//	Declare All Variables	
	
	private int desk_id;
	private int cm;
	private int rd;
	private int rm;
	private int pc;
	private int ao;
	private int tml;
	private int tmtd;
	private int tmsa;
	private int r;
	private int la;
	
//	Define Constructor
	
	public Module(){}
	
	public Module(int desk_id, int cm, int rd, int rm, int pc, int ao, int tml, int tmtd, int tmsa, int r, int la) {
	      this.setDesk_id(desk_id);
	      this.setCm(cm);
	      this.setRd(rd);
	      this.setRm(rm);
	      this.setPc(pc);
	      this.setAo(ao);
	      this.setTml(tml);
	      this.setTmtd(tmtd);
	      this.setTmsa(tmsa);
	      this.setR(r);
	      this.setLa(la);
	}

	/**
	 * @return the desk_id
	 */
	public int getDesk_id() {
		return desk_id;
	}

	/**
	 * @param desk_id the desk_id to set
	 */
	public void setDesk_id(int desk_id) {
		this.desk_id = desk_id;
	}

	/**
	 * @return the cm
	 */
	public int getCm() {
		return cm;
	}

	/**
	 * @param cm the cm to set
	 */
	public void setCm(int cm) {
		this.cm = cm;
	}

	/**
	 * @return the rd
	 */
	public int getRd() {
		return rd;
	}

	/**
	 * @param rd the rd to set
	 */
	public void setRd(int rd) {
		this.rd = rd;
	}

	/**
	 * @return the pc
	 */
	
	/**
	 * @return the rm
	 */
	public int getRm() {
		return rm;
	}

	/**
	 * @param rm the rm to set
	 */
	public void setRm(int rm) {
		this.rm = rm;
	}
	
	public int getPc() {
		return pc;
	}

	/**
	 * @param pc the pc to set
	 */
	public void setPc(int pc) {
		this.pc = pc;
	}

	/**
	 * @return the ao
	 */
	public int getAo() {
		return ao;
	}

	/**
	 * @param ao the ao to set
	 */
	public void setAo(int ao) {
		this.ao = ao;
	}

	/**
	 * @return the tml
	 */
	public int getTml() {
		return tml;
	}

	/**
	 * @param tml the tml to set
	 */
	public void setTml(int tml) {
		this.tml = tml;
	}

	/**
	 * @return the tmtd
	 */
	public int getTmtd() {
		return tmtd;
	}

	/**
	 * @param tmtd the tmtd to set
	 */
	public void setTmtd(int tmtd) {
		this.tmtd = tmtd;
	}
	
	/**
	 * @return the tmsa
	 */
	public int getTmsa() {
		return tmsa;
	}

	/**
	 * @param tmsa the tmsa to set
	 */
	public void setTmsa(int tmsa) {
		this.tmsa = tmsa;
	}

	/**
	 * @return the r
	 */
	public int getR() {
		return r;
	}

	/**
	 * @param r the r to set
	 */
	public void setR(int r) {
		this.r = r;
	}

	/**
	 * @return the la
	 */
	public int getLa() {
		return la;
	}

	/**
	 * @param la the la to set
	 */
	public void setLa(int la) {
		this.la = la;
	}

	@Override
	public String toString() {
		return "Module [desk_id=" + desk_id + ", cm=" + cm + ", rd=" + rd + ", rm=" + rm + ", pc=" + pc + ", ao=" + ao
				+ ", tml=" + tml + ", tmtd=" + tmtd + ", tmsa=" + tmsa + ", r=" + r + ", la=" + la + "]";
	}
	
}