package modelo;

public final class Win32 extends Motor {

	/*
	 * Constructor; Se define la velocidad Maxima
	 */
	public Win32() {
		velocidadMaxima = 100.0;
	}

	// Metodo Sobreescrito
	@Override
	protected double calcularTiempo(double velocidadInstantanea) {

		double tiempo = -Math.log(1.0 - velocidadInstantanea / velocidadMaxima) / 0.9;

		if (1 / tiempo == 0.0)
			tiempo = 10;

		return tiempo;
	}

	// Metodo Sobreescrito
	@Override
	protected double evaluarFuncionVelocidad(double difTiempo, double tiempo) {

		double velocidad = velocidadMaxima
				* (1.0 - Math.exp(-(tiempo + difTiempo) * 0.9));

		return velocidad;
	}

	// Metodo Sobreescrito
	@Override
	public String motor() {
		return "Win32";
	}

}
