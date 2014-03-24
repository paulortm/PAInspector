package ist.meic.pa.commands;

import java.util.List;

import ist.meic.pa.Inspector;

import java.lang.reflect.Field;

public class Cmd_i implements Command {

	public Cmd_i() {
		super();
	}

	@Override
	public void execute(Inspector insp, List<String> args) {
		try {

			// pega o objecto corrente
			Object ob = insp.obtainCurrentObj();

			// pega a classe do objecto
			Class<?> classe = ob.getClass();

			// pega o atributo name do obj
			Field fd = classe.getDeclaredField("name");

			// actualiza o name do obj
			fd.set(ob, args.get(0));

			// adiciona o obj como recente
			insp.modifyCurrentObj(ob);

		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}