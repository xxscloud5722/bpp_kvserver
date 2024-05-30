import Fetch from 'beer-network/api';
import { Session } from 'beer-network/session';

class KeyApi extends Fetch {
  async list<T>(keyword: string) {
    const token = Session.getBearer();
    return this.get<T>(`/pair/list${keyword === undefined || keyword === '' ? '' : '/' + keyword}`, { token });
  }

  async save(params: {}) {
    const token = Session.getBearer();
    return this.putBody<any>('/pair', { token }, params);
  }

  async remove(key: string) {
    const token = Session.getBearer();
    return this.delete<any>('/pair', {
      key,
      token
    });
  }
}

export default new KeyApi(import.meta.env.VITE_REQUEST_BASE_URL?.toString());
