package design.adapter;

// 어댑터 클래스
public class EletronicAdapter implements IElectronic220v {

    private IElectronic110v iElectronic110v;

    EletronicAdapter(IElectronic110v iElectronic110v) {
        this.iElectronic110v = iElectronic110v;
    }

    @Override
    public void connect() {
        iElectronic110v.connect();
    }
}
