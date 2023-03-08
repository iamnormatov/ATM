public class ATM {
    private Integer machineId;
    private Double balance;
    private String location;
    private Boolean status;

    public ATM(Double balance, String location, Boolean status) {
        this.balance = balance;
        this.location = location;
        this.status = status;
    }

    public String toATM() {
        return "ATM{" +
                "machineId=" + machineId +
                ", balance=" + balance +
                ", location='" + location + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
