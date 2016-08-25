package cn.maitian.api.base;

public class DataResponse<D> extends BaseResponse {
    private D data;

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}