package raytracer;

/**
 * Représente un vecteur.
 * Certaines méthode retournent <tt>this</tt> après l'avoir modifier pour
 * pouvoir chaine les opérations.
 */
public class Vector3d extends Tuple3d {
    /** Constructeur par défaut */
    public Vector3d() {
        super();
    }

    /** Constructeur
     * @param x
     * @param y
     * @param z
     */
    public Vector3d(double x, double y, double z) {
        super(x, y, z);
    }

    /** Constructeur
     * @param xyz
     */
    public Vector3d(double[] xyz) {
        super(xyz);
    }

    /** Constructeur par copie
     * @param other
     */
    public Vector3d(Tuple3d other) {
        super(other);
    }

    /**
     * Représente le vecteur AB ou B-A.
     * @param B
     * @param A
     */
    public Vector3d(Tuple3d B, Tuple3d A) {
        set(B.x-A.x, B.y-A.y, B.z-A.z);
    }

    /**
     * Retourne la norme du vecteur
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * Retourne la norme au carré du vecteur
     */
    public double lengthSquared() {
        return dot(this);
    }

    /**
     * Effectue le produit scalaire entre <tt>this</tt> et <tt>other</tt>.
     * @param other
     */
    public double dot(Vector3d other) {
        return x*other.x + y*other.y + z*other.z;
    }

    /**
     * Effectue le produit vectoriel entre <tt>this</tt> et <tt>other</tt>.
     * Modifie cet object.
     * @param other
     * @return this
     */
    public Vector3d cross(Vector3d other) {
        set(
            y*other.z - z*other.y,
            z*other.x - x*other.z,
            x*other.y - y*other.x
        );
        return this;
    }

    /**
     * Multiplie ce vecteur par <tt>s</tt>.
     * @param s Le facteur
     * @return this
     */
    public Vector3d scale(double s) {
        x *= s; y *= s; z *= s;
        return this;
    }

    /**
     * Réalise <tt>this = s*t</tt>.
     * @param s Le facteur
     * @param t Le vecteur
     */
    public void scale(double s, Vector3d t) {
        set(new Vector3d(t).scale(s));
    }

    /**
     * Normalise ce vecteur.
     * @return this
     */
    public Vector3d normalize() {
        scale(1.d/length());
        return this;
    }

    /**
     * Retourne l'angle entre <tt>this</tt> et <tt>other</tt>
     * @param other
     */
    public double angle(Vector3d other) {
        return Math.acos(dot(other) / (length() * other.length()));
    }

    /**
     * Ajoute <tt>rhs</tt> à ce vecteur.
     * @param rhs
     * @return this
     */
    public Vector3d add(Tuple3d rhs) {
        x += rhs.x; y += rhs.y; z += rhs.z;
        return this;
    }

    /**
     * Réalise <tt>this = lhs+rhs</tt>.
     * @param lhs
     * @param rhs
     */
    public void add(Vector3d lhs, Vector3d rhs) {
        set(new Vector3d(lhs).add(rhs));
    }

    /**
     * Soustrait <tt>rhs</tt> à ce vecteur.
     * @param rhs
     * @return this
     */
    public Vector3d sub(Vector3d rhs) {
        x -= rhs.x; y -= rhs.y; z -= rhs.z;
        return this;
    }

    /**
     * Réalise <tt>this = lhs-rhs</tt>.
     * @param lhs
     * @param rhs
     */
    public void sub(Vector3d lhs, Vector3d rhs) {
        set(new Vector3d(lhs).sub(rhs));
    }

    /**
     * Fait la symétrie du vecteur par rapport à celui passé en paramètre.
     * @param other
     */
    public Vector3d symmetry(Vector3d other)
    {
        double dd = 2.d*dot(other);
        x = other.x*dd - x;
        y = other.y*dd - y;
        z = other.z*dd - z;
        return this;
    }

}

