package prog2.tp_6_pt2;

public class Universidad {
    private String nombre;
    private List<Profesor> profesores = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProfesor(Profesor p) { profesores.add(p); }
    public void agregarCurso(Curso c) { cursos.add(c); }

    public Profesor buscarProfesorPorId(String id) {
        return profesores.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        return cursos.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor prof = buscarProfesorPorId(idProfesor);
        if (curso != null && prof != null) curso.setProfesor(prof);
    }

    public void listarProfesores() {
        profesores.forEach(Profesor::mostrarInfo);
    }

    public void listarCursos() {
        cursos.forEach(Curso::mostrarInfo);
    }

    public void eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            if (curso.getProfesor() != null) {
                curso.getProfesor().getCursos().remove(curso);
            }
            cursos.remove(curso);
        }
    }

    public void eliminarProfesor(String id) {
        Profesor prof = buscarProfesorPorId(id);
        if (prof != null) {
            for (Curso c : new ArrayList<>(prof.getCursos())) {
                c.setProfesor(null);
            }
            profesores.remove(prof);
        }
    }

    public void reporteCursosPorProfesor() {
        for (Profesor p : profesores) {
            System.out.println(p.getNombre() + ": " + p.getCursos().size() + " cursos");
        }
    }
}