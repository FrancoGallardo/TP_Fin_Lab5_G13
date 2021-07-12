package funcionesDAO;

import java.util.List;
import entidad.TipoCuenta;

public interface TipoCuentaDAO {

	public boolean insertarTipoCuenta(TipoCuenta tipoCuenta);
	public TipoCuenta obtenerTipoCuenta(int id);
	public boolean buscarTipoCuenta(int id);
	public List<TipoCuenta> obtenerTipoCuenta();
	public boolean modificar(TipoCuenta tipoCuenta);
	public void Finalizar();
	public void Inicializar();
}
